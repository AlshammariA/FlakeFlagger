@Test public void traverse() throws Exception {
  NodeBuilder builder=EMPTY_NODE.builder();
  NodeBuilder parents=builder.child("parents");
  parents.child("p0").setProperty("id",0);
  parents.child("p1").setProperty("id",1);
  parents.child("p2").setProperty("id",2);
  NodeBuilder children=builder.child("children");
  children.child("c1").setProperty("p","1");
  children.child("c2").setProperty("p","1");
  children.child("c3").setProperty("p","2");
  children.child("c4").setProperty("p","3");
  NodeState root=builder.getNodeState();
  TraversingIndex t=new TraversingIndex();
  FilterImpl f=new FilterImpl();
  f.setPath("/");
  Cursor c=t.query(f,root);
  List<String> paths=new ArrayList<String>();
  while (c.hasNext()) {
    paths.add(c.next().getPath());
  }
  Collections.sort(paths);
  assertEquals(Arrays.asList("/","/children","/children/c1","/children/c2","/children/c3","/children/c4","/parents","/parents/p0","/parents/p1","/parents/p2"),paths);
  assertFalse(c.hasNext());
  assertFalse(c.hasNext());
  f.setPath("/nowhere");
  c=t.query(f,root);
  assertFalse(c.hasNext());
  assertFalse(c.hasNext());
}
