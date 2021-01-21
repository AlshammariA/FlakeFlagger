@Test public void testSingularAggregation(){
  try {
    Tree privTree=createPrivilegeTree();
    privTree.setProperty(PropertyStates.createProperty(REP_AGGREGATES,Collections.singletonList(JCR_READ),Type.NAMES));
    PrivilegeBits.getInstance(bitsProvider.getBits(JCR_READ)).writeTo(privTree);
    root.commit();
    fail("Aggregation of a single privilege is invalid.");
  }
 catch (  CommitFailedException e) {
    assertEquals("OakConstraint0050: Singular aggregation is equivalent to existing privilege.",e.getMessage());
  }
 finally {
    root.refresh();
  }
}
