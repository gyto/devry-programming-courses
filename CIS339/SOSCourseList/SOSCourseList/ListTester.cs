using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SOSCourseList
{
    class Sub
    {
        // Create a object which will have number, name, credit hours, summary, and prerequisites
        public Sub(string classNumber, string className, int creditHours, string classSummary, string preSub)
        {
            this.SubID = classNumber;
            this.SubTitle = className;
            this.CreditHours = creditHours;
            this.Summary = classSummary;
            this.PreSub = preSub;
        }

        // make the object to be public accessible 
        public string SubID;
        public string SubTitle;
        public int CreditHours;
        public string Summary;
        public string PreSub;

    }

    class ListTester
    {
        public static void Main(string[] args)
        {
            GetCourseByIDCourseExist();
            GetCourseByIDCourseDoesNotExist();

            Console.WriteLine("Unit Test is Passed!");
            Console.ReadKey();
        }

        // Check if the class is exist
        public static void GetCourseByIDCourseExist()
        {
            Sublist list = new Sublist();
            string lookUpCourse = "CIS 339";
            Sub course = list.GetCourseByCourseID(lookUpCourse);
            if (course.SubID != lookUpCourse)
                System.Console.WriteLine("ERROR - GetCourseByIDCourseExist(): Returned ID does not matches to " + lookUpCourse);
        }

        // Check if the class does not exist 
        public static void GetCourseByIDCourseDoesNotExist()
        {
            Sublist list = new Sublist();
            string lookUpCourse = "SEC 370";
            Sub course = list.GetCourseByCourseID(lookUpCourse);
            if (course != null)
                System.Console.WriteLine("ERROR - GetCourseByIDCourseDoesNotExist(): must return null");
        }
    }

    class Sublist
    {
        // Create object-array items
        public Sub[] subArray =
        {
            new Sub ("CIS 339", "Object-Oriented Analysis and Design", 4, "Building on the foundation established in...", "CIS 321"),
            new Sub ("SEC 370", "Web Security", 4, "This course examines issues involved in protecting web-based...", "SEC 280")
        };

        // Check each object-array item
        public Sub GetCourseByCourseID(string courseNumber)
        {
            return subArray.Where(item => item.SubID == courseNumber).FirstOrDefault();
        }
    }
}
