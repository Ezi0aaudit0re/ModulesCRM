import mysql.connector
import collections


"""
    THis file connects to the database
"""



def connectDB():
    try:
        config = {
            'user': 'root',
            'password': 'root',
            'host': '127.0.0.1',
            'database': 'ModulesCRM',
            'raise_on_warnings': True
        }

        cnx = mysql.connector.connect(**config)

        return cnx
    except Exception as e:
        print("Conneciton Failed")
        exit(2)
    finally:
        print("Connection established")



def save_information(information, cursor):



    # create courese query
    add_course = "Insert Into courses " \
                 "(name, description, department, code, school, url, credits, pre_req)" \
                 "VALUES (%s, %s, %s, %s, %s, %s, %s, %s)"
    val = (information["name"], information["description"], information["department"], information["code"], information["school"], information["url"], information["schedule"]["credits"], information["schedule"]["pre_requisites"])

    # insert course and get id
    cursor.execute(add_course, val)


    course_id = cursor.lastrowid

    # insert schedule with the id
    for sec in information["schedule"]["section"]:
        add_section = "Insert into section" \
                      "(date, section, instructor, location, time, notes, course_id)" \
                      "VALUES (%s, %s,%s,%s,%s,%s,%s)"
        val = (sec["time"], sec["section"], sec["instructor"], sec["location"], sec["time"], sec["notes"], course_id)

        cursor.execute(add_section, val)




if __name__ == "__main__":
    connectDB();


