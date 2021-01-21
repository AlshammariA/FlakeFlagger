@Test public void testBitsConflictWithAggregation(){
  try {
    Tree privTree=createPrivilegeTree();
    privTree.setProperty(PropertyStates.createProperty(REP_AGGREGATES,ImmutableList.of(JCR_READ,JCR_MODIFY_PROPERTIES),Type.NAMES));
    setPrivilegeBits(privTree,REP_BITS,340);
    root.commit();
    fail("Privilege bits don't match the aggregation.");
  }
 catch (  CommitFailedException e) {
    assertEquals("OakConstraint0053: Invalid privilege bits for aggregated privilege definition.",e.getMessage());
  }
 finally {
    root.refresh();
  }
}
