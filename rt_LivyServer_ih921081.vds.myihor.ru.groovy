import ru.neoflex.meta.utils.Context
def session = Context.current.txSession
def entity = session.createQuery("from rt.LivyServer where name = :name").setParameter("name", "ih921081.vds.myihor.ru").uniqueResult() 
entity.project = null
Context.current.commit()
