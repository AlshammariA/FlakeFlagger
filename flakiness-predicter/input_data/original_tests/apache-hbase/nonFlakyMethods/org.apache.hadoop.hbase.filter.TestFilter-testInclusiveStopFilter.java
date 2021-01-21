public void testInclusiveStopFilter() throws IOException {
  long expectedRows=(this.numRows / 2) - 1;
  long expectedKeys=this.colsPerRow;
  Scan s=new Scan(Bytes.toBytes("testRowOne-0"),Bytes.toBytes("testRowOne-3"));
  verifyScan(s,expectedRows,expectedKeys);
  expectedRows=this.numRows / 2;
  s=new Scan(Bytes.toBytes("testRowOne-0"));
  s.setFilter(new InclusiveStopFilter(Bytes.toBytes("testRowOne-3")));
  verifyScan(s,expectedRows,expectedKeys);
  expectedRows=(this.numRows / 2) - 1;
  expectedKeys=this.colsPerRow;
  s=new Scan(Bytes.toBytes("testRowTwo-0"),Bytes.toBytes("testRowTwo-3"));
  verifyScan(s,expectedRows,expectedKeys);
  expectedRows=this.numRows / 2;
  s=new Scan(Bytes.toBytes("testRowTwo-0"));
  s.setFilter(new InclusiveStopFilter(Bytes.toBytes("testRowTwo-3")));
  verifyScan(s,expectedRows,expectedKeys);
}
