import ru.neoflex.meta.utils.Context
def session = Context.current.txSession
def entity = session.createQuery("from rt.JdbcConnection where name = :name").setParameter("name", "myihor_phoenix").uniqueResult() 
entity.project = null
Context.current.commit()
