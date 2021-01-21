/** 
 * tests the output of a plan where the query is asked with where conditions that are not indexed but the ORDER BY are on the indexed property eg: SELECT * FROM [nt:base] WHERE pinned=1 ORDER BY lastModified
 * @throws RepositoryException
 * @throws IllegalArgumentException
 * @throws CommitFailedException
 */
@Test public void planOrderAndWhereMixed() throws IllegalArgumentException, RepositoryException, CommitFailedException {
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
  FilterImpl filter=createFilter(indexed,nodeTypeName);
  filter.restrictProperty("somethingNotIndexed",Operator.EQUAL,PropertyValues.newLong(1L));
  List<QueryIndex.OrderEntry> sortOrder=ImmutableList.of(createOrderEntry(ORDERED_PROPERTY,order));
  List<IndexPlan> plans=index.getPlans(filter,sortOrder,indexed);
  assertNotNull(plans);
  assertEquals(1,plans.size());
  IndexPlan p=plans.get(0);
  assertTrue(p.getEstimatedEntryCount() > 0);
  assertNotNull(p.getSortOrder());
  assertEquals(1,p.getSortOrder().size());
  assertEquals(QueryIndex.OrderEntry.Order.ASCENDING,p.getSortOrder().get(0).getOrder());
}
