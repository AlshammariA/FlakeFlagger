@Test public void elect(){
  SingletonElectionPolicy policy=mock(SingletonElectionPolicy.class);
  Preference preference1=mock(Preference.class);
  Preference preference2=mock(Preference.class);
  Node node1=mock(Node.class);
  Node node2=mock(Node.class);
  Node node3=mock(Node.class);
  Node node4=mock(Node.class);
  when(preference1.preferred(same(node1))).thenReturn(true);
  when(preference1.preferred(same(node2))).thenReturn(false);
  when(preference1.preferred(same(node3))).thenReturn(false);
  when(preference1.preferred(same(node4))).thenReturn(false);
  when(preference2.preferred(same(node1))).thenReturn(false);
  when(preference2.preferred(same(node2))).thenReturn(true);
  when(preference2.preferred(same(node3))).thenReturn(false);
  when(preference2.preferred(same(node4))).thenReturn(false);
  assertSame(node1,new PreferredSingletonElectionPolicy(policy,preference1,preference2).elect(Arrays.asList(node1,node2,node3,node4)));
  assertSame(node1,new PreferredSingletonElectionPolicy(policy,preference1,preference2).elect(Arrays.asList(node4,node3,node2,node1)));
  assertSame(node2,new PreferredSingletonElectionPolicy(policy,preference1,preference2).elect(Arrays.asList(node2,node3,node4)));
  assertSame(node2,new PreferredSingletonElectionPolicy(policy,preference1,preference2).elect(Arrays.asList(node4,node3,node2)));
  List<Node> nodes=Arrays.asList(node3,node4);
  when(policy.elect(nodes)).thenReturn(node3);
  assertSame(node3,new PreferredSingletonElectionPolicy(policy,preference1,preference2).elect(nodes));
  when(policy.elect(nodes)).thenReturn(node4);
  assertSame(node4,new PreferredSingletonElectionPolicy(policy,preference1,preference2).elect(nodes));
  when(policy.elect(nodes)).thenReturn(null);
  assertNull(new PreferredSingletonElectionPolicy(policy,preference1,preference2).elect(nodes));
}
