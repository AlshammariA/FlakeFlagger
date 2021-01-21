@Test public void fromStringToString(){
  for (int i=0; i < 10000; i++) {
    Revision r=Revision.newRevision(i);
    Revision r2=Revision.fromString(r.toString());
    assertEquals(r.toString(),r2.toString());
    assertEquals(r.hashCode(),r2.hashCode());
    assertTrue(r.equals(r2));
  }
}
