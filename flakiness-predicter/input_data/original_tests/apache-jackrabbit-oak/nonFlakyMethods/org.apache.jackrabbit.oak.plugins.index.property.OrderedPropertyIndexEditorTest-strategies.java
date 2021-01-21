@Test public void strategies(){
  final String property="foobar";
  NodeBuilder definition=EmptyNodeState.EMPTY_NODE.builder();
  definition.setProperty(IndexConstants.PROPERTY_NAMES,property);
  definition.setProperty(OrderedIndex.DIRECTION,OrderDirection.ASC.getDirection());
  OrderedPropertyIndexEditor editor=new OrderedPropertyIndexEditor(definition,null,null);
  assertEquals(OrderedPropertyIndexEditor.ORDERED_MIRROR,editor.getStrategy(false));
  definition=EmptyNodeState.EMPTY_NODE.builder();
  definition.setProperty(IndexConstants.PROPERTY_NAMES,property);
  definition.setProperty(OrderedIndex.DIRECTION,OrderDirection.DESC.getDirection());
  editor=new OrderedPropertyIndexEditor(definition,null,null);
  assertEquals(OrderedPropertyIndexEditor.ORDERED_MIRROR_DESCENDING,editor.getStrategy(false));
}
