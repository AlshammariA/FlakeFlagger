public void testSingleCellGetPutXML() throws IOException, JAXBException {
  Response response=getValueXML(TABLE,ROW_1,COLUMN_1);
  assertEquals(response.getCode(),404);
  response=putValueXML(TABLE,ROW_1,COLUMN_1,VALUE_1);
  assertEquals(response.getCode(),200);
  checkValueXML(TABLE,ROW_1,COLUMN_1,VALUE_1);
  response=putValueXML(TABLE,ROW_1,COLUMN_1,VALUE_2);
  assertEquals(response.getCode(),200);
  checkValueXML(TABLE,ROW_1,COLUMN_1,VALUE_2);
  response=deleteRow(TABLE,ROW_1);
  assertEquals(response.getCode(),200);
}
