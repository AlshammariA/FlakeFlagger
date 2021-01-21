/** 
 * **&#47/y/z should match x/y/x/y/z
 */
@Test public void starStarGlob(){
  EventFilter rootFilter=new GlobbingPathFilter("**/y/z");
  NodeState x1=tree.getChild("x").getNodeState();
  assertFalse(rootFilter.includeAdd("x",x1));
  EventFilter x1Filter=rootFilter.create("x",x1,x1);
  assertNotNull(x1Filter);
  NodeState y1=x1.getChildNode("y");
  assertFalse(x1Filter.includeAdd("y",y1));
  EventFilter y1Filter=x1Filter.create("y",y1,y1);
  assertNotNull(y1Filter);
  NodeState x2=y1.getChildNode("x");
  assertFalse(y1Filter.includeAdd("x",x2));
  EventFilter x2Filter=y1Filter.create("x",x2,x2);
  assertNotNull(x2Filter);
  NodeState y2=x2.getChildNode("y");
  assertFalse(x2Filter.includeAdd("y",y2));
  EventFilter y2Filter=x2Filter.create("y",y2,y2);
  assertNotNull(y2Filter);
  NodeState z=y2.getChildNode("z");
  assertTrue(y2Filter.includeAdd("z",z));
  EventFilter zFilter=(y2Filter.create("z",z,z));
  assertFalse(zFilter.includeAdd("x",EMPTY_NODE));
}
