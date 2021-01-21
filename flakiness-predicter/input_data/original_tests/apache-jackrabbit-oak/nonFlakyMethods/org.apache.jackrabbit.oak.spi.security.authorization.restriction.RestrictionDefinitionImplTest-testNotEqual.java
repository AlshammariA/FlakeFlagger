@Test public void testNotEqual(){
  List<RestrictionDefinition> defs=new ArrayList<RestrictionDefinition>();
  defs.add(new RestrictionDefinitionImpl(name,Type.STRING,true));
  defs.add(new RestrictionDefinitionImpl("otherName",Type.NAME,true));
  defs.add(new RestrictionDefinitionImpl(name,Type.NAME,false));
  defs.add(new RestrictionDefinitionImpl(name,Type.NAMES,true));
  defs.add(new RestrictionDefinition(){
    @Override public String getName(){
      return name;
    }
    @Override public Type<?> getRequiredType(){
      return Type.NAME;
    }
    @Override public boolean isMandatory(){
      return true;
    }
  }
);
  for (  RestrictionDefinition rd : defs) {
    assertFalse(definition.equals(rd));
  }
}
