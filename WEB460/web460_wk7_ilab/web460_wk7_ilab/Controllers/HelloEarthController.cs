using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace web460_wk7_ilab.Controllers
{
    public class HelloEarthController : Controller
    {
        //
        // GET: /HelloEarth/

        // get action result
        public ActionResult Index()
        {
            return View();
        }

        // set default action
        //public string Index()
        //{
        //    return "This is the <strong>default action</strong> for this web site ...!";
        //}

        // set welcome action
        public ActionResult Welcome(string visitor, int numTimes = 1)
        {
            //return HttpUtility.HtmlEncode("Hello " + visitor + "! Your number is " + numTimes);
            ViewBag.VisitorName = visitor;
            ViewBag.NumTimes = numTimes;

            return View();
        }
        // set welcome action
        //public string Welcome(string visitor, int numTimes = 1)
        //{
            //return HttpUtility.HtmlEncode("Hello " + visitor + "! Your number is " + numTimes);
        //}
    }
}
