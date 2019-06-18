import ru.neoflex.meta.utils.Context
def session = Context.current.txSession
def entity = session.createQuery("from rt.TransformationDeployment where name = :name").setParameter("name", "autogenerated_tr_bp_drools_1").uniqueResult() 
entity.deployments.clear()
entity.project = session.createQuery("from etl.Project where name = :name").setParameter("name", "blueprint_git").uniqueResult()
entity.livyServer = session.createQuery("from rt.LivyServer where name = :name").setParameter("name", "ih921081.vds.myihor.ru").uniqueResult()
entity.transformation = session.createQuery("from etl.Transformation where name = :name").setParameter("name", "bp_drools_1").uniqueResult()
Context.current.commit()