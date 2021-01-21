@Test public void should_format_xml_string_with_space_and_newline_prettily(){
  String xmlString="<?xml version=\"1.0\" encoding=\"UTF-8\"?><rss version=\"2.0\"><channel>  <title>Java Tutorials and Examples 1</title>  \n\n<language>en-us</language>  </channel></rss>";
  assertThat(xmlPrettyFormat(xmlString)).isEqualTo(EXPECTED_FORMATTED_XML);
}
