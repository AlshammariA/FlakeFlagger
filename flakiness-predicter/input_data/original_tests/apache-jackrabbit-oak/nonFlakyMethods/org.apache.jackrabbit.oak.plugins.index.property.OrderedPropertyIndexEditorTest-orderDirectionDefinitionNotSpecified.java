@Test public void orderDirectionDefinitionNotSpecified(){
  final String property="foobar";
  NodeBuilder definition=EmptyNodeState.EMPTY_NODE.builder();
  definition.setProperty(IndexConstants.PROPERTY_NAMES,property);
  OrderedPropertyIndexEditor editor=new OrderedPropertyIndexEditor(definition,null,null);
  assertNotNull(editor.getPropertyNames());
  assertEquals(property,editor.getPropertyNames().iterator().next());
  assertEquals(OrderedIndex.OrderDirection.ASC,editor.getDirection());
}
