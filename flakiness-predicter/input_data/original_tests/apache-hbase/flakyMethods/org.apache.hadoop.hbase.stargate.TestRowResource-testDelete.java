public void testDelete() throws IOException, JAXBException {
  Response response;
  response=putValueXML(TABLE,ROW_1,COLUMN_1,VALUE_1);
  assertEquals(response.getCode(),200);
  response=putValueXML(TABLE,ROW_1,COLUMN_2,VALUE_2);
  assertEquals(response.getCode(),200);
  checkValueXML(TABLE,ROW_1,COLUMN_1,VALUE_1);
  checkValueXML(TABLE,ROW_1,COLUMN_2,VALUE_2);
  response=deleteValue(TABLE,ROW_1,COLUMN_1);
  assertEquals(response.getCode(),200);
  response=getValueXML(TABLE,ROW_1,COLUMN_1);
  assertEquals(response.getCode(),404);
  checkValueXML(TABLE,ROW_1,COLUMN_2,VALUE_2);
  response=deleteRow(TABLE,ROW_1);
  assertEquals(response.getCode(),200);
  response=getValueXML(TABLE,ROW_1,COLUMN_1);
  assertEquals(response.getCode(),404);
  response=getValueXML(TABLE,ROW_1,COLUMN_2);
  assertEquals(response.getCode(),404);
}
