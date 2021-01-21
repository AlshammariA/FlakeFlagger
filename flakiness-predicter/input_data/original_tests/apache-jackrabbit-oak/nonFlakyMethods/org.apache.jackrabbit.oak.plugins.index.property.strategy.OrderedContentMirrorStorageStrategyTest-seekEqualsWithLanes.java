/** 
 * testing the seek method and the returned lanes with the following index structure <code> List Structure ============== STR 000 001 002 003 004 005 006 007 008 009 010 011 012 NIL |-->o-->o-->o-->o-->o-->o-->o-->o-->o-->o-->o-->o-->o-->| |------>o------>o------>o------>o---------->o---------->| |-------------->o-------------->o---------->o---------->| |------------------------------------------>o---------->| </code>
 */
@Test public void seekEqualsWithLanes(){
  OrderedContentMirrorStoreStrategy store=new OrderedContentMirrorStoreStrategy();
  NodeBuilder builder=EmptyNodeState.EMPTY_NODE.builder();
  String n00=KEYS[0];
  String n01=KEYS[1];
  String n02=KEYS[2];
  String n03=KEYS[3];
  String n04=KEYS[4];
  String n05=KEYS[5];
  String n06=KEYS[6];
  String n07=KEYS[7];
  String n08=KEYS[8];
  String n09=KEYS[9];
  String n10=KEYS[10];
  String n11=KEYS[11];
  String n12=KEYS[12];
  builder.child(START).setProperty(NEXT,ImmutableList.of(n00,n01,n03,n10),Type.STRINGS);
  builder.child(n00).setProperty(NEXT,ImmutableList.of(n01,"","",""),Type.STRINGS);
  builder.child(n01).setProperty(NEXT,ImmutableList.of(n02,n03,"",""),Type.STRINGS);
  builder.child(n02).setProperty(NEXT,ImmutableList.of(n03,"","",""),Type.STRINGS);
  builder.child(n03).setProperty(NEXT,ImmutableList.of(n04,n05,n07,""),Type.STRINGS);
  builder.child(n04).setProperty(NEXT,ImmutableList.of(n05,"","",""),Type.STRINGS);
  builder.child(n05).setProperty(NEXT,ImmutableList.of(n06,n07,"",""),Type.STRINGS);
  builder.child(n06).setProperty(NEXT,ImmutableList.of(n07,"","",""),Type.STRINGS);
  builder.child(n07).setProperty(NEXT,ImmutableList.of(n08,n10,n10,""),Type.STRINGS);
  builder.child(n08).setProperty(NEXT,ImmutableList.of(n09,"","",""),Type.STRINGS);
  builder.child(n09).setProperty(NEXT,ImmutableList.of(n10,n12,"",""),Type.STRINGS);
  builder.child(n10).setProperty(NEXT,ImmutableList.of(n11,"","",""),Type.STRINGS);
  builder.child(n11).setProperty(NEXT,ImmutableList.of(n12,"","",""),Type.STRINGS);
  builder.child(n12).setProperty(NEXT,ImmutableList.of("","","",""),Type.STRINGS);
  NodeState index=builder.getNodeState();
  printSkipList(index);
  String searchFor="wedontcareaswetesttheexception";
  NodeState node=index.getChildNode(searchFor);
  ChildNodeEntry entry=new OrderedChildNodeEntry(searchFor,node);
  ChildNodeEntry[] wl=new ChildNodeEntry[0];
  ChildNodeEntry item=null;
  ChildNodeEntry lane0, lane1, lane2, lane3;
  try {
    item=store.seek(index,new OrderedContentMirrorStoreStrategy.PredicateEquals(searchFor),wl);
    fail("With a wrong size for the lane it should have raised an exception");
  }
 catch (  IllegalArgumentException e) {
  }
  searchFor=n12;
  lane3=new OrderedChildNodeEntry(n10,index.getChildNode(n10));
  lane2=new OrderedChildNodeEntry(n10,index.getChildNode(n10));
  lane1=new OrderedChildNodeEntry(n10,index.getChildNode(n10));
  lane0=new OrderedChildNodeEntry(n11,index.getChildNode(n11));
  entry=new OrderedChildNodeEntry(searchFor,index.getChildNode(searchFor));
  wl=new ChildNodeEntry[OrderedIndex.LANES];
  item=store.seek(index,new OrderedContentMirrorStoreStrategy.PredicateEquals(searchFor),wl);
  assertNotNull(wl);
  assertEquals(OrderedIndex.LANES,wl.length);
  assertEquals("Wrong lane",lane0,wl[0]);
  assertEquals("Wrong lane",lane1,wl[1]);
  assertEquals("Wrong lane",lane2,wl[2]);
  assertEquals("Wrong lane",lane3,wl[3]);
  assertEquals("Wrong item returned",entry,item);
  searchFor=n08;
  lane3=new OrderedChildNodeEntry(START,index.getChildNode(START));
  lane2=new OrderedChildNodeEntry(n07,index.getChildNode(n07));
  lane1=new OrderedChildNodeEntry(n07,index.getChildNode(n07));
  lane0=new OrderedChildNodeEntry(n07,index.getChildNode(n07));
  entry=new OrderedChildNodeEntry(searchFor,index.getChildNode(searchFor));
  wl=new ChildNodeEntry[OrderedIndex.LANES];
  item=store.seek(index,new OrderedContentMirrorStoreStrategy.PredicateEquals(searchFor),wl);
  assertNotNull(wl);
  assertEquals(OrderedIndex.LANES,wl.length);
  assertEquals("Wrong lane",lane0,wl[0]);
  assertEquals("Wrong lane",lane1,wl[1]);
  assertEquals("Wrong lane",lane2,wl[2]);
  assertEquals("Wrong lane",lane3,wl[3]);
  assertEquals("Wrong item returned",entry,item);
  searchFor=n06;
  lane3=new OrderedChildNodeEntry(START,index.getChildNode(START));
  lane2=new OrderedChildNodeEntry(n03,index.getChildNode(n03));
  lane1=new OrderedChildNodeEntry(n05,index.getChildNode(n05));
  lane0=new OrderedChildNodeEntry(n05,index.getChildNode(n05));
  entry=new OrderedChildNodeEntry(searchFor,index.getChildNode(searchFor));
  wl=new ChildNodeEntry[OrderedIndex.LANES];
  item=store.seek(index,new OrderedContentMirrorStoreStrategy.PredicateEquals(searchFor),wl);
  assertNotNull(wl);
  assertEquals(OrderedIndex.LANES,wl.length);
  assertEquals("Wrong lane",lane0,wl[0]);
  assertEquals("Wrong lane",lane1,wl[1]);
  assertEquals("Wrong lane",lane2,wl[2]);
  assertEquals("Wrong lane",lane3,wl[3]);
  assertEquals("Wrong item returned",entry,item);
}
