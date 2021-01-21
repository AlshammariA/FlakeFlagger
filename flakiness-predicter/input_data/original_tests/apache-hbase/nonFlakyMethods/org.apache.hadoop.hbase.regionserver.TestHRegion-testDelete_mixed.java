public void testDelete_mixed() throws IOException {
  byte[] tableName=Bytes.toBytes("testtable");
  byte[] fam=Bytes.toBytes("info");
  byte[][] families={fam};
  String method=this.getName();
  initHRegion(tableName,method,families);
  byte[] row=Bytes.toBytes("table_name");
  byte[] serverinfo=Bytes.toBytes("serverinfo");
  byte[] splitA=Bytes.toBytes("splitA");
  byte[] splitB=Bytes.toBytes("splitB");
  Put put=new Put(row);
  put.add(fam,splitA,Bytes.toBytes("reference_A"));
  region.put(put);
  put=new Put(row);
  put.add(fam,splitB,Bytes.toBytes("reference_B"));
  region.put(put);
  put=new Put(row);
  put.add(fam,serverinfo,Bytes.toBytes("ip_address"));
  region.put(put);
  Delete delete=new Delete(row);
  delete.deleteColumns(fam,splitA);
  region.delete(delete,null,true);
  Get get=new Get(row).addColumn(fam,serverinfo);
  Result result=region.get(get,null);
  assertEquals(1,result.size());
  get=new Get(row).addColumn(fam,splitA);
  result=region.get(get,null);
  assertEquals(0,result.size());
  get=new Get(row).addColumn(fam,splitB);
  result=region.get(get,null);
  assertEquals(1,result.size());
  put=new Put(row);
  put.add(fam,splitA,Bytes.toBytes("reference_A"));
  region.put(put);
  get=new Get(row);
  result=region.get(get,null);
  assertEquals(3,result.size());
  delete=new Delete(row);
  region.delete(delete,null,false);
  assertEquals(0,region.get(get,null).size());
  try {
    Thread.sleep(10);
  }
 catch (  InterruptedException e) {
    e.printStackTrace();
  }
  region.put(new Put(row).add(fam,splitA,Bytes.toBytes("reference_A")));
  result=region.get(get,null);
  assertEquals(1,result.size());
}
