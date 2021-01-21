public void testSingleCellGetPutBinary() throws IOException {
  final String path="/" + TABLE + "/"+ ROW_3+ "/"+ COLUMN_1;
  final byte[] body=Bytes.toBytes(VALUE_3);
  Response response=client.put(path,MIMETYPE_BINARY,body);
  assertEquals(response.getCode(),200);
  Thread.yield();
  response=client.get(path,MIMETYPE_BINARY);
  assertEquals(response.getCode(),200);
  assertTrue(Bytes.equals(response.getBody(),body));
  boolean foundTimestampHeader=false;
  for (  Header header : response.getHeaders()) {
    if (header.getName().equals("X-Timestamp")) {
      foundTimestampHeader=true;
      break;
    }
  }
  assertTrue(foundTimestampHeader);
  response=deleteRow(TABLE,ROW_3);
  assertEquals(response.getCode(),200);
}
