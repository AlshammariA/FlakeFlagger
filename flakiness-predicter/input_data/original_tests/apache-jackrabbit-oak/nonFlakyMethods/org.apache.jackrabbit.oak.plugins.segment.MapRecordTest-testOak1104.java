@Test public void testOak1104(){
  Pattern pattern=Pattern.compile(", ");
  Set<String> beforeNames=newHashSet(pattern.split("_b_Lucene41_0.doc, _b.fdx, _b.fdt, segments_34, _b_4.del," + " _b_Lucene41_0.pos, _b.nvm, _b.nvd, _b.fnm, _3n.si," + " _b_Lucene41_0.tip, _b_Lucene41_0.tim, _3n.cfe,"+ " segments.gen, _3n.cfs, _b.si"));
  Set<String> afterNames=newHashSet(pattern.split("_b_Lucene41_0.pos, _3k.cfs, _3j_1.del, _b.nvm, _b.nvd," + " _3d.cfe, _3d.cfs, _b.fnm, _3j.si, _3h.si, _3i.cfe," + " _3i.cfs, _3e_2.del, _3f.si, _b_Lucene41_0.tip,"+ " _b_Lucene41_0.tim, segments.gen, _3e.cfe, _3e.cfs,"+ " _b.si, _3g.si, _3l.si, _3i_1.del, _3d_3.del, _3e.si,"+ " _3d.si, _b_Lucene41_0.doc, _3h_2.del, _3i.si, _3k_1.del,"+ " _3j.cfe, _3j.cfs, _b.fdx, _b.fdt, _3g_1.del, _3k.si,"+ " _3l.cfe, _3l.cfs, segments_33, _3f_1.del, _3h.cfe,"+ " _3h.cfs, _b_4.del, _3f.cfe, _3f.cfs, _3g.cfe, _3g.cfs"));
  for (  String name : beforeNames) {
    builder.setChildNode(name);
  }
  NodeState before=builder.getNodeState();
  for (  String name : Sets.difference(beforeNames,afterNames)) {
    builder.getChildNode(name).remove();
  }
  for (  String name : Sets.difference(afterNames,beforeNames)) {
    builder.setChildNode(name);
  }
  NodeState after=builder.getNodeState();
  for (  String name : Sets.difference(beforeNames,afterNames)) {
    expect(diff.childNodeDeleted(name,before.getChildNode(name))).andReturn(true);
  }
  for (  String name : Sets.difference(afterNames,beforeNames)) {
    expect(diff.childNodeAdded(name,after.getChildNode(name))).andReturn(true);
  }
  replay(diff);
  after.compareAgainstBaseState(before,diff);
  verify(diff);
}
