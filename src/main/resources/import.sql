INSERT INTO public.role (id, name) VALUES (101, 'ROLE_ADMIN');
INSERT INTO public.role (id, name) VALUES (102, 'ROLE_USER');

INSERT INTO public.function(id, code, description, view) VALUES (101, 'ADMIN_HOME_VIEW', null, 'admin-home');
INSERT INTO public.function(id, code, description, view) VALUES (102, 'ADMIN_SECRET_VIEW', null, 'admin-secret');
INSERT INTO public.function(id, code, description, view) VALUES (103, 'HOME_VIEW', null, '');
INSERT INTO public.function(id, code, description, view) VALUES (104, 'REGISTER_VIEW', null, 'register');
INSERT INTO public.function(id, code, description, view) VALUES (105, 'USER_HOME_VIEW', null, 'user-home');
INSERT INTO public.function(id, code, description, view) VALUES (106, 'ACCESS_CONTROL_VIEW', null, 'access');

INSERT INTO public.roles_functions(role_id, function_id) VALUES (101, 101);
INSERT INTO public.roles_functions(role_id, function_id) VALUES (101, 102);
INSERT INTO public.roles_functions(role_id, function_id) VALUES (101, 103);
INSERT INTO public.roles_functions(role_id, function_id) VALUES (101, 104);
INSERT INTO public.roles_functions(role_id, function_id) VALUES (101, 105);
INSERT INTO public.roles_functions(role_id, function_id) VALUES (101, 106);

INSERT INTO public.roles_functions(role_id, function_id) VALUES (102, 101);
INSERT INTO public.roles_functions(role_id, function_id) VALUES (102, 102);
INSERT INTO public.roles_functions(role_id, function_id) VALUES (102, 103);
INSERT INTO public.roles_functions(role_id, function_id) VALUES (102, 104);
INSERT INTO public.roles_functions(role_id, function_id) VALUES (102, 105);

