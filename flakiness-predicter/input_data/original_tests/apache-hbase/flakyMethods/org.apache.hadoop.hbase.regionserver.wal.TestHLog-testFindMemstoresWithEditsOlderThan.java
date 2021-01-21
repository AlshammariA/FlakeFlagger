/** 
 * Test the findMemstoresWithEditsOlderThan method.
 * @throws IOException
 */
public void testFindMemstoresWithEditsOlderThan() throws IOException {
  Map<byte[],Long> regionsToSeqids=new HashMap<byte[],Long>();
  for (int i=0; i < 10; i++) {
    Long l=Long.valueOf(i);
    regionsToSeqids.put(l.toString().getBytes(),l);
  }
  byte[][] regions=HLog.findMemstoresWithEditsOlderThan(1,regionsToSeqids);
  assertEquals(1,regions.length);
  assertTrue(Bytes.equals(regions[0],"0".getBytes()));
  regions=HLog.findMemstoresWithEditsOlderThan(3,regionsToSeqids);
  int count=3;
  assertEquals(count,regions.length);
  for (int i=0; i < count; i++) {
    assertTrue(Bytes.equals(regions[i],"0".getBytes()) || Bytes.equals(regions[i],"1".getBytes()) || Bytes.equals(regions[i],"2".getBytes()));
  }
}
