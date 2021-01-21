@Test public void predicateLessThan(){
  Predicate<ChildNodeEntry> predicate;
  String searchfor;
  ChildNodeEntry entry;
  searchfor="b";
  predicate=new PredicateLessThan(searchfor,true);
  entry=new OrderedChildNodeEntry("a",EmptyNodeState.EMPTY_NODE);
  assertTrue(predicate.apply(entry));
  searchfor="a";
  predicate=new PredicateLessThan(searchfor,true);
  entry=new OrderedChildNodeEntry("b",EmptyNodeState.EMPTY_NODE);
  assertFalse(predicate.apply(entry));
  searchfor="a";
  predicate=new PredicateLessThan(searchfor,true);
  entry=null;
  assertFalse(predicate.apply(entry));
}
