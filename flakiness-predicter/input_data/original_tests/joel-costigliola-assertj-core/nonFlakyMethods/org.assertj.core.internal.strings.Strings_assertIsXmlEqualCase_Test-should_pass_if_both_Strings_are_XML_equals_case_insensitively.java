@Test public void should_pass_if_both_Strings_are_XML_equals_case_insensitively(){
  String actual="<rss version=\"2.0\"><Channel><title>Java Tutorials</title></Channel></rss>";
  String expected="<rss version=\"2.0\"><channel><TITLE>JAVA Tutorials</TITLE></channel></rss>";
  stringsWithCaseInsensitiveComparisonStrategy.assertXmlEqualsTo(someInfo(),actual,expected);
}
