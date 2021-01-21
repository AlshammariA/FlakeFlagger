public void testMultiCellGetPutXML() throws IOException, JAXBException {
  String path="/" + TABLE + "/fakerow";
  CellSetModel cellSetModel=new CellSetModel();
  RowModel rowModel=new RowModel(ROW_1);
  rowModel.addCell(new CellModel(Bytes.toBytes(COLUMN_1),Bytes.toBytes(VALUE_1)));
  rowModel.addCell(new CellModel(Bytes.toBytes(COLUMN_2),Bytes.toBytes(VALUE_2)));
  cellSetModel.addRow(rowModel);
  rowModel=new RowModel(ROW_2);
  rowModel.addCell(new CellModel(Bytes.toBytes(COLUMN_1),Bytes.toBytes(VALUE_3)));
  rowModel.addCell(new CellModel(Bytes.toBytes(COLUMN_2),Bytes.toBytes(VALUE_4)));
  cellSetModel.addRow(rowModel);
  StringWriter writer=new StringWriter();
  marshaller.marshal(cellSetModel,writer);
  Response response=client.put(path,MIMETYPE_XML,Bytes.toBytes(writer.toString()));
  Thread.yield();
  response=client.get(path,MIMETYPE_XML);
  assertEquals(response.getCode(),404);
  checkValueXML(TABLE,ROW_1,COLUMN_1,VALUE_1);
  checkValueXML(TABLE,ROW_1,COLUMN_2,VALUE_2);
  checkValueXML(TABLE,ROW_2,COLUMN_1,VALUE_3);
  checkValueXML(TABLE,ROW_2,COLUMN_2,VALUE_4);
  response=deleteRow(TABLE,ROW_1);
  assertEquals(response.getCode(),200);
  response=deleteRow(TABLE,ROW_2);
  assertEquals(response.getCode(),200);
}
