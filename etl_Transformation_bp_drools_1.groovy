import ru.neoflex.meta.utils.Context
def session = Context.current.txSession
def entity = session.createQuery("from etl.Transformation where name = :name").setParameter("name", "bp_drools_1").uniqueResult() 
entity.userDefinedFunctions.clear()
entity.project = session.createQuery("from etl.Project where name = :name").setParameter("name", "blueprint_git").uniqueResult()
entity.targets.find {it.name == "Local_2"}.context = null
entity.sources.find {it.name == "Expression_0"}.context = null
Context.current.commit()
