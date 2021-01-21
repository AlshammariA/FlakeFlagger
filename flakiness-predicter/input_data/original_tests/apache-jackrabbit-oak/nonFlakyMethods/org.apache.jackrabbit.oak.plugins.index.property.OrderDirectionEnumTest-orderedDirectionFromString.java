@Test public void orderedDirectionFromString(){
  assertNull("A non-existing order direction should result in null",OrderDirection.fromString("foobar"));
  assertEquals(OrderDirection.ASC,OrderDirection.fromString("ascending"));
  assertFalse(OrderDirection.ASC.equals(OrderDirection.fromString("descending")));
  assertEquals(OrderDirection.DESC,OrderDirection.fromString("descending"));
  assertFalse(OrderDirection.DESC.equals(OrderDirection.fromString("ascending")));
}
