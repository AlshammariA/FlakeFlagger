public void testColumnCompare() throws Exception {
  final byte[] a=Bytes.toBytes("aaa");
  byte[] family1=Bytes.toBytes("abc");
  byte[] qualifier1=Bytes.toBytes("def");
  byte[] family2=Bytes.toBytes("abcd");
  byte[] qualifier2=Bytes.toBytes("ef");
  KeyValue aaa=new KeyValue(a,family1,qualifier1,0L,Type.Put,a);
  assertFalse(aaa.matchingColumn(family2,qualifier2));
  assertTrue(aaa.matchingColumn(family1,qualifier1));
  aaa=new KeyValue(a,family2,qualifier2,0L,Type.Put,a);
  assertFalse(aaa.matchingColumn(family1,qualifier1));
  assertTrue(aaa.matchingColumn(family2,qualifier2));
  byte[] nullQualifier=new byte[0];
  aaa=new KeyValue(a,family1,nullQualifier,0L,Type.Put,a);
  assertTrue(aaa.matchingColumn(family1,null));
  assertFalse(aaa.matchingColumn(family2,qualifier2));
}
