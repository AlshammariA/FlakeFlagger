/** 
 * For HBASE-694 
 */
public void testGetClosestRowBefore2() throws IOException {
  HRegion region=null;
  byte[] c0=COLUMNS[0];
  try {
    HTableDescriptor htd=createTableDescriptor(getName());
    region=createNewHRegion(htd,null,null);
    Put p=new Put(T10);
    p.add(c0,c0,T10);
    region.put(p);
    p=new Put(T30);
    p.add(c0,c0,T30);
    region.put(p);
    p=new Put(T40);
    p.add(c0,c0,T40);
    region.put(p);
    Result r=region.getClosestRowBefore(T35,c0);
    assertTrue(Bytes.equals(T30,r.getRow()));
    region.flushcache();
    r=region.getClosestRowBefore(T35,c0);
    assertTrue(Bytes.equals(T30,r.getRow()));
    p=new Put(T20);
    p.add(c0,c0,T20);
    region.put(p);
    r=region.getClosestRowBefore(T35,c0);
    assertTrue(Bytes.equals(T30,r.getRow()));
    region.flushcache();
    r=region.getClosestRowBefore(T35,c0);
    assertTrue(Bytes.equals(T30,r.getRow()));
  }
  finally {
    if (region != null) {
      try {
        region.close();
      }
 catch (      Exception e) {
        e.printStackTrace();
      }
      region.getLog().closeAndDelete();
    }
  }
}
