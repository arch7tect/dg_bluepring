import ru.neoflex.meta.utils.Context
def session = Context.current.txSession
def entity = session.createQuery("from etl.Transformation where name = :name").setParameter("name", "bp_hbase_lookup").uniqueResult() 
entity.userDefinedFunctions.clear()
entity.project = session.createQuery("from etl.Project where name = :name").setParameter("name", "blueprint_git").uniqueResult()
entity.userDefinedFunctions.add(session.createQuery("from etl.UserDefinedFunction where name = :name").setParameter("name", "LONG2BINARY").uniqueResult())
entity.userDefinedFunctions.add(session.createQuery("from etl.UserDefinedFunction where name = :name").setParameter("name", "BINARY2BOOLEAN").uniqueResult())
entity.userDefinedFunctions.add(session.createQuery("from etl.UserDefinedFunction where name = :name").setParameter("name", "BINARY2LONG").uniqueResult())
entity.userDefinedFunctions.add(session.createQuery("from etl.UserDefinedFunction where name = :name").setParameter("name", "BINARY2STRING").uniqueResult())
entity.userDefinedFunctions.add(session.createQuery("from etl.UserDefinedFunction where name = :name").setParameter("name", "HBASE_LOOKUP").uniqueResult())
entity.targets.find {it.name == "Local_3"}.context = null
entity.sources.find {it.name == "Expression_0"}.context = null
Context.current.commit()
