@Test public void equalsHashCode(){
  Revision a=Revision.newRevision(0);
  Revision b=Revision.newRevision(0);
  assertTrue(a.equals(a));
  assertFalse(a.equals(b));
  assertFalse(b.equals(a));
  assertFalse(a.hashCode() == b.hashCode());
  Revision a1=Revision.fromString(a.toString());
  assertTrue(a.equals(a1));
  assertTrue(a1.equals(a));
  Revision a2=new Revision(a.getTimestamp(),a.getCounter(),a.getClusterId());
  assertTrue(a.equals(a2));
  assertTrue(a2.equals(a));
  assertEquals(a.hashCode(),a1.hashCode());
  assertEquals(a.hashCode(),a2.hashCode());
  Revision x1=new Revision(a.getTimestamp() + 1,a.getCounter(),a.getClusterId());
  assertFalse(a.equals(x1));
  assertFalse(x1.equals(a));
  assertFalse(a.hashCode() == x1.hashCode());
  Revision x2=new Revision(a.getTimestamp(),a.getCounter() + 1,a.getClusterId());
  assertFalse(a.equals(x2));
  assertFalse(x2.equals(a));
  assertFalse(a.hashCode() == x2.hashCode());
  Revision x3=new Revision(a.getTimestamp(),a.getCounter(),a.getClusterId() + 1);
  assertFalse(a.equals(x3));
  assertFalse(x3.equals(a));
  assertFalse(a.hashCode() == x3.hashCode());
}
