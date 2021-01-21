@Test public void testInsertGetDelete(){
  simpleCassandraDao.insert("fk1","colName1","value1");
  assertEquals("value1",simpleCassandraDao.get("fk1","colName1"));
  simpleCassandraDao.delete("colName1","fk1");
  assertNull(simpleCassandraDao.get("fk1","colName1"));
}
