import ru.neoflex.meta.utils.Context
def session = Context.current.txSession
def entity = session.createQuery("from etl.UserDefinedFunction where name = :name").setParameter("name", "BINARY2BOOLEAN").uniqueResult() 
entity.project = session.createQuery("from etl.Project where name = :name").setParameter("name", "blueprint_git").uniqueResult()
Context.current.commit()
