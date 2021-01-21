@Test public void orderDirectionUnknownDefinition(){
  final String property="foobar";
  NodeBuilder definition=EmptyNodeState.EMPTY_NODE.builder();
  definition.setProperty(IndexConstants.PROPERTY_NAMES,property);
  definition.setProperty(OrderedIndex.DIRECTION,"bazbaz");
  OrderedPropertyIndexEditor editor=new OrderedPropertyIndexEditor(definition,null,null);
  assertNotNull(editor.getPropertyNames());
  assertEquals(property,editor.getPropertyNames().iterator().next());
  assertEquals("if we provide a non-valid definition for order the Ascending is expected",OrderedIndex.OrderDirection.ASC,editor.getDirection());
}
