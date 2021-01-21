@Test public void should_fail_if_both_Strings_are_not_XML_equal_regardless_of_case(){
  AssertionInfo info=someInfo();
  String actual="<rss version=\"2.0\"><channel><title>Java Tutorials</title></channel></rss>";
  String expected="<rss version=\"2.0\"><channel><title>Java Tutorials and Examples</title></channel></rss>";
  try {
    stringsWithCaseInsensitiveComparisonStrategy.assertXmlEqualsTo(someInfo(),actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeEqual(xmlPrettyFormat(actual),xmlPrettyFormat(expected),info.representation()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
