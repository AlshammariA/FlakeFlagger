public void testNullHashCode(){
  byte[] b=null;
  Exception ee=null;
  try {
    Bytes.hashCode(b);
  }
 catch (  Exception e) {
    ee=e;
  }
  assertNotNull(ee);
}
