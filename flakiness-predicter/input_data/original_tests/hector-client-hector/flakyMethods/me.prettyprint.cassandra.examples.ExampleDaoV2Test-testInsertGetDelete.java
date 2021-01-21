@Test public void testInsertGetDelete() throws HectorException {
  Cluster c=getOrCreateCluster("MyCluster","localhost:9170");
  ExampleDaoV2 dao=new ExampleDaoV2(createKeyspace("Keyspace1",c));
  assertNull(dao.get("key",StringSerializer.get()));
  dao.insert("key","value",StringSerializer.get());
  assertEquals("value",dao.get("key",StringSerializer.get()));
  dao.delete(StringSerializer.get(),"key");
  assertNull(dao.get("key",StringSerializer.get()));
}
