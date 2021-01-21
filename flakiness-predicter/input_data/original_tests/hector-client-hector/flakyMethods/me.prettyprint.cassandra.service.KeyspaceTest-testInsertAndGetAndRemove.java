@Test public void testInsertAndGetAndRemove() throws IllegalArgumentException, NoSuchElementException, IllegalStateException, HNotFoundException, Exception {
  ColumnPath cp=new ColumnPath("Standard1");
  cp.setColumn(bytes("testInsertAndGetAndRemove"));
  for (int i=0; i < 100; i++) {
    keyspace.insert("testInsertAndGetAndRemove_" + i,cp,StringSerializer.get().toByteBuffer("testInsertAndGetAndRemove_value_" + i));
  }
  for (int i=0; i < 100; i++) {
    Column col=keyspace.getColumn("testInsertAndGetAndRemove_" + i,cp);
    assertNotNull(col);
    String value=string(col.getValue());
    assertEquals("testInsertAndGetAndRemove_value_" + i,value);
  }
  for (int i=0; i < 100; i++) {
    keyspace.remove("testInsertAndGetAndRemove_" + i,cp);
  }
  for (int i=0; i < 100; i++) {
    try {
      keyspace.getColumn("testInsertAndGetAndRemove_" + i,cp);
      fail("the value should already being deleted");
    }
 catch (    HNotFoundException e) {
    }
  }
}
