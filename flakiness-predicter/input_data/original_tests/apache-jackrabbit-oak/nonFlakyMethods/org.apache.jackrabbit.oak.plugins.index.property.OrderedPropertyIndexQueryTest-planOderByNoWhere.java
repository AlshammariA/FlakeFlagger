@Test public void planOderByNoWhere() throws IllegalArgumentException, RepositoryException, CommitFailedException {
  NodeBuilder root=EmptyNodeState.EMPTY_NODE.builder();
  IndexUtils.createIndexDefinition(root.child(IndexConstants.INDEX_DEFINITIONS_NAME),TEST_INDEX_NAME,false,ImmutableList.of(ORDERED_PROPERTY),null,OrderedIndex.TYPE,ImmutableMap.<String,String>of());
  NodeState before=root.getNodeState();
  final OrderDirection direction=OrderDirection.ASC;
  final QueryIndex.OrderEntry.Order order=OrderDirection.ASC.equals(direction) ? QueryIndex.OrderEntry.Order.ASCENDING : QueryIndex.OrderEntry.Order.DESCENDING;
  List<String> values=generateOrderedValues(NUMBER_OF_NODES,direction);
  addChildNodes(values,root,Type.STRING);
  NodeState after=root.getNodeState();
  NodeState indexed=HOOK.processCommit(before,after,CommitInfo.EMPTY);
  final OrderedPropertyIndex index=new OrderedPropertyIndex();
  final String nodeTypeName=JcrConstants.NT_BASE;
  Filter filter=createFilter(indexed,nodeTypeName);
  List<QueryIndex.OrderEntry> sortOrder=ImmutableList.of(createOrderEntry(ORDERED_PROPERTY,order));
  List<IndexPlan> plans=index.getPlans(filter,sortOrder,indexed);
  assertNotNull(plans);
  assertEquals(1,plans.size());
  IndexPlan p=plans.get(0);
  assertTrue(p.getEstimatedEntryCount() > 0);
  assertNotNull(p.getSortOrder());
  assertEquals(1,p.getSortOrder().size());
  QueryIndex.OrderEntry oe=p.getSortOrder().get(0);
  assertNotNull(oe);
  assertEquals(ORDERED_PROPERTY,oe.getPropertyName());
  assertEquals(QueryIndex.OrderEntry.Order.ASCENDING,oe.getOrder());
}
