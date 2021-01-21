@Test public void testNodeSize(){
  NodeBuilder builder=EMPTY_NODE.builder();
  assertEquals(48,getSize(builder));
  assertEquals(4,getAmortizedSize(builder));
  builder=EMPTY_NODE.builder();
  builder.setProperty("foo","bar");
  assertEquals(48,getSize(builder));
  assertEquals(8,getAmortizedSize(builder));
  builder=EMPTY_NODE.builder();
  builder.setProperty("foo","bar");
  builder.setProperty("baz",123);
  assertEquals(64,getSize(builder));
  assertEquals(12,getAmortizedSize(builder));
  builder=EMPTY_NODE.builder();
  builder.child("foo");
  assertEquals(64,getSize(builder));
  assertEquals(12,getAmortizedSize(builder));
  builder=EMPTY_NODE.builder();
  builder.child("foo");
  builder.child("bar");
  assertEquals(96,getSize(builder));
  assertEquals(40,getAmortizedSize(builder));
}
