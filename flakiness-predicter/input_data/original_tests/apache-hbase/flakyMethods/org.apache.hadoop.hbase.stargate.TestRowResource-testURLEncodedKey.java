public void testURLEncodedKey() throws IOException, JAXBException {
  String encodedKey=URLEncoder.encode("http://www.google.com/",HConstants.UTF8_ENCODING);
  Response response;
  response=putValueXML(TABLE,encodedKey,COLUMN_1,VALUE_1);
  assertEquals(response.getCode(),200);
  response=putValuePB(TABLE,encodedKey,COLUMN_2,VALUE_2);
  assertEquals(response.getCode(),200);
  checkValuePB(TABLE,encodedKey,COLUMN_1,VALUE_1);
  checkValueXML(TABLE,encodedKey,COLUMN_2,VALUE_2);
}
