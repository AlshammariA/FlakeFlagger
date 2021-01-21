public void testSingleCellGetJSON() throws IOException, JAXBException {
  final String path="/" + TABLE + "/"+ ROW_4+ "/"+ COLUMN_1;
  Response response=client.put(path,MIMETYPE_BINARY,Bytes.toBytes(VALUE_4));
  assertEquals(response.getCode(),200);
  Thread.yield();
  response=client.get(path,MIMETYPE_JSON);
  assertEquals(response.getCode(),200);
  response=deleteRow(TABLE,ROW_4);
  assertEquals(response.getCode(),200);
}
