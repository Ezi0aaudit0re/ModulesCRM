import requests
from bs4 import BeautifulSoup
import traceback
import dbConnect


logger = []


def create_soup(url):
    try:
        page = requests.get(url)
        soup = BeautifulSoup(page.content, 'html.parser')
        return soup
    except Exception as e:
        print(str(e))
        logger.append(url)




def get_courses_from_page(url, connection):

    # get a soup
    soup = create_soup(url)

    if not soup: return

    # get information
    ul = soup.find_all(class_="course-feed")

    if len(ul) > 1:
        raise Exception("More than 1 course-feed on the page: {}".format(url))

    for li in ul[0].find_all('li', recursive=False):
        try:
            information = extract_from_element(li)
            # get section for those courses with new url
            information["schedule"] = get_course_section(information["url"] if information["url"] else None)

            # save the information in the database by executing query
            print(information)
            dbConnect.save_information(information, connection.cursor())
        except Exception as e:
            raise Exception("Course: {}, error: {}, stack_trace: {}".format(li.text, str(e), traceback.format_exc() ))
            continue


    # commit the insert
    connection.commit()
    print("*" * 25)
    print("saved url: {}".format(url))
    print("*" * 25)


# date, section, instructor, location, credits, time, notes
def get_course_section(url):
    if not url: raise Exception("Problem getting section information")

    soup = create_soup(url)
    return_dict = {}

    info = soup.find(id="info-box")

    info = info.find_all("dd")

    # default credit of 1
    return_dict["credits"]= info[0].text if len(info) >= 1 else 1

    return_dict["pre_requisites"] = info[1].text if len(info) >= 2 else None

    # get section information

    section_information = soup.find(class_="cf-course")

    if not section_information:
        return return_dict

    return_dict["section"]= []

    for sec_info in section_information.find_all("table"):
        section, instructor, location, schedule, notes = sec_info.find_all("td")
        temp = {"section": section.text, "instructor": instructor.text, "location": location.text, "time": schedule.text, "notes": notes.text}
        return_dict["section"].append(temp)

    return return_dict





# name, description, department, code, school, credits
def extract_from_element(li):
    if not li: raise Exception("No information in li")

    extract_header = li.find("strong")

    course_url = "http://bu.edu" + li.find("a", href=True)["href"] if li.find("a") else None

    department_information, name = extract_header.text.split(":")[:2]

    school, department, code = department_information.split(" ")



    description = li.text.replace("\t", "").split("\n")[-1]

    return {"name": name, "description": description, "department": department, "code": code, "school": school, "url": course_url}





def driver():

    # connect to the database
    connection = dbConnect.connectDB()

    URL = "https://www.bu.edu/academics/cas/courses/"
    for i in range(2, 113):
        temp_url = URL  + str(i)
        print("\n" * 4)
        print("URL is: {}".format(temp_url))
        try:
           get_courses_from_page(temp_url, connection)
        except Exception as e:
            logger.append("{}: {}".format(temp_url, e))
            continue


    print("Logging information: \n{}".format(logger))



if __name__ == "__main__":
    driver()
