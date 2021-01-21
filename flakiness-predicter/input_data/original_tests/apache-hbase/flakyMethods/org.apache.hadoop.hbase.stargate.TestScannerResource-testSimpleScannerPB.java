public void testSimpleScannerPB() throws IOException {
  final int BATCH_SIZE=10;
  ScannerModel model=new ScannerModel();
  model.setBatch(BATCH_SIZE);
  model.addColumn(Bytes.toBytes(COLUMN_1));
  Response response=client.put("/" + TABLE + "/scanner",MIMETYPE_PROTOBUF,model.createProtobufOutput());
  assertEquals(response.getCode(),201);
  String scannerURI=response.getLocation();
  assertNotNull(scannerURI);
  response=client.get(scannerURI,MIMETYPE_PROTOBUF);
  assertEquals(response.getCode(),200);
  CellSetModel cellSet=new CellSetModel();
  cellSet.getObjectFromMessage(response.getBody());
  assertEquals(countCellSet(cellSet),BATCH_SIZE);
  response=client.delete(scannerURI);
  assertEquals(response.getCode(),200);
}
