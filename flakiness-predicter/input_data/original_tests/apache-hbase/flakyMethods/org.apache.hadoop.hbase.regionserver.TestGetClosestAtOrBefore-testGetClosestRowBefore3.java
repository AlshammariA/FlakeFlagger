/** 
 * Test file of multiple deletes and with deletes as final key.
 * @see <a href="https://issues.apache.org/jira/browse/HBASE-751">HBASE-751</a>
 */
public void testGetClosestRowBefore3() throws IOException {
  HRegion region=null;
  byte[] c0=COLUMNS[0];
  byte[] c1=COLUMNS[1];
  try {
    HTableDescriptor htd=createTableDescriptor(getName());
    region=createNewHRegion(htd,null,null);
    Put p=new Put(T00);
    p.add(c0,c0,T00);
    region.put(p);
    p=new Put(T10);
    p.add(c0,c0,T10);
    region.put(p);
    p=new Put(T20);
    p.add(c0,c0,T20);
    region.put(p);
    Result r=region.getClosestRowBefore(T20,c0);
    assertTrue(Bytes.equals(T20,r.getRow()));
    Delete d=new Delete(T20);
    d.deleteColumn(c0,c0);
    region.delete(d,null,false);
    r=region.getClosestRowBefore(T20,c0);
    assertTrue(Bytes.equals(T10,r.getRow()));
    p=new Put(T30);
    p.add(c0,c0,T30);
    region.put(p);
    r=region.getClosestRowBefore(T30,c0);
    assertTrue(Bytes.equals(T30,r.getRow()));
    d=new Delete(T30);
    d.deleteColumn(c0,c0);
    region.delete(d,null,false);
    r=region.getClosestRowBefore(T30,c0);
    assertTrue(Bytes.equals(T10,r.getRow()));
    r=region.getClosestRowBefore(T31,c0);
    assertTrue(Bytes.equals(T10,r.getRow()));
    region.flushcache();
    r=region.getClosestRowBefore(T30,c0);
    assertTrue(Bytes.equals(T10,r.getRow()));
    r=region.getClosestRowBefore(T31,c0);
    assertTrue(Bytes.equals(T10,r.getRow()));
    p=new Put(T20);
    p.add(c1,c1,T20);
    region.put(p);
    r=region.getClosestRowBefore(T30,c0);
    assertTrue(Bytes.equals(T10,r.getRow()));
    r=region.getClosestRowBefore(T31,c0);
    assertTrue(Bytes.equals(T10,r.getRow()));
    region.flushcache();
    r=region.getClosestRowBefore(T30,c0);
    assertTrue(Bytes.equals(T10,r.getRow()));
    r=region.getClosestRowBefore(T31,c0);
    assertTrue(Bytes.equals(T10,r.getRow()));
    d=new Delete(T20);
    d.deleteColumn(c1,c1);
    region.delete(d,null,false);
    r=region.getClosestRowBefore(T30,c0);
    assertTrue(Bytes.equals(T10,r.getRow()));
    r=region.getClosestRowBefore(T31,c0);
    assertTrue(Bytes.equals(T10,r.getRow()));
    region.flushcache();
    r=region.getClosestRowBefore(T31,c0);
    assertTrue(Bytes.equals(T10,r.getRow()));
    p=new Put(T11);
    p.add(c0,c0,T11);
    region.put(p);
    d=new Delete(T10);
    d.deleteColumn(c1,c1);
    r=region.getClosestRowBefore(T12,c0);
    assertTrue(Bytes.equals(T11,r.getRow()));
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
