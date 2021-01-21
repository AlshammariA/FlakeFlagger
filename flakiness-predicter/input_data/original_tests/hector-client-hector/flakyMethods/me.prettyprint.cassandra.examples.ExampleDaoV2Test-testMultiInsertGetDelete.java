@Test public void testMultiInsertGetDelete() throws HectorException {
  Cluster c=getOrCreateCluster("MyCluster","localhost:9170");
  ExampleDaoV2 dao=new ExampleDaoV2(createKeyspace("Keyspace1",c));
  Map<String,String> ret=dao.getMulti(StringSerializer.get(),"key1","key2");
  assertNotNull(ret);
  assertNull("value1",ret.get("key1"));
  Map<String,String> keyValues=new HashMap<String,String>();
  keyValues.put("key1","value1");
  keyValues.put("key2","value2");
  dao.insertMulti(keyValues,StringSerializer.get());
  ret=dao.getMulti(StringSerializer.get(),"key1","key2");
  assertNotNull(ret);
  assertEquals("value1",ret.get("key1"));
  assertEquals("value2",ret.get("key2"));
  ret=dao.getMulti(StringSerializer.get(),"key2","key3");
  assertNotNull(ret);
  assertEquals("value2",ret.get("key2"));
  assertNull(ret.get("key3"));
  assertNull(ret.get("key1"));
  dao.delete(StringSerializer.get(),"key1","key2");
  ret=dao.getMulti(StringSerializer.get(),"key1","key2");
  assertNotNull(ret);
  assertNull(ret.get("key1"));
  assertNull(ret.get("key2"));
}
