@Test public void should_pass_if_both_Strings_are_XML_equals(){
  String actual="<rss version=\"2.0\"><channel>  <title>Java Tutorials and Examples 1</title>  <language>en-us</language></channel></rss>";
  String expected="<rss version=\"2.0\">\n" + "<channel><title>Java Tutorials and Examples 1</title><language>en-us</language></channel>\n" + "</rss>";
  strings.assertXmlEqualsTo(someInfo(),actual,expected);
}
