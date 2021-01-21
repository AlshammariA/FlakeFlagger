@Test public void should_format_xml_string_without_xml_declaration_prettily(){
  String xmlString="<rss version=\"2.0\"><channel><title>Java Tutorials and Examples 1</title><language>en-us</language></channel></rss>";
  assertThat(xmlPrettyFormat(xmlString)).isEqualTo(EXPECTED_FORMATTED_XML.substring("<?xml version='1.0' encoding='UTF-8'?>\n".length()));
}
