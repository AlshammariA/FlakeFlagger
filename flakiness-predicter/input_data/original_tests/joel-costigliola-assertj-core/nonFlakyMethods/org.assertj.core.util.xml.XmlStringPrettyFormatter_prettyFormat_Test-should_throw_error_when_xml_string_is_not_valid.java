@Test public void should_throw_error_when_xml_string_is_not_valid(){
  String xmlString="<?xml version=\"1.0\" encoding=\"UTF-8\"?><rss version=\"2.0\"><channel><title>Java Tutorials and Examples 1</title><language>en-us</language></chnel></rss>";
  try {
    xmlPrettyFormat(xmlString);
  }
 catch (  Exception e) {
    assertThat(e).isInstanceOf(RuntimeException.class).hasMessageStartingWith("Unable to format XML string");
    assertThat(e).hasRootCauseInstanceOf(SAXParseException.class);
    assertThat(e.getCause()).hasMessageContaining("The element type \"channel\" must be terminated by the matching end-tag \"</channel>\"");
  }
}
