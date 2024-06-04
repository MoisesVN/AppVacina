import { View } from "react-native";
import { createNativeStackNavigator } from '@react-navigation/native-stack';

import styles from "./style";
import PrivateRoute from "./private";

// Importação das páginas/componentes do aplicativo
import Main from '../components/main';
import Cadastro from '../components/cadastro';
import RecuperarConta from '../components/recuperarConta';
import RedefiniSenha from '../components/redefiniSenha';
import Home from '../components/home';
import CarteiraCadastro from '../components/carteiraCadastro';
import Carteira from '../components/carteira';
import VacinaCadastro from '../components/vacinaCadastro';
import MenuConfig from '../components/menuConfig';
// Importação das páginas/componentes do aplicativo

// Criação do navegador de pilha nativo
const Stack = createNativeStackNavigator();

// Componente funcional para a tela de login
function Login(){
    return(
        <View style={styles.container}>
            <Main/>
        </View>
    );
}

// Componente funcional para as rotas de navegação
export default function TabRoutes(){
    
    return(
        
        /* Options={{ headerShown: false }} indica que o cabeçalho não será exibido */
        <Stack.Navigator>
            <Stack.Screen
            name = 'Login'
            component={Login}
            options={{ headerShown: false}}
            />
            <Stack.Screen
            name = 'Main'
            component={Main}
            options={{ headerShown: false}}
            />
            <Stack.Screen
            name = 'Cadastro'
            component={Cadastro}
            options={{ headerShown: false}}
            />
            <Stack.Screen
            name = 'RecuperarConta'
            component={RecuperarConta}
            options={{ headerShown: false}}
            />
            <Stack.Screen
            name = 'RedefiniSenha'
            component={RedefiniSenha}
            options={{ headerShown: false}}
            />
            <Stack.Screen
                name = 'Home'
                options={{ headerShown: false}}>
                    {() => (
                        <PrivateRoute>
                            <Home />
                        </PrivateRoute>
                    )}
                </Stack.Screen>
            <Stack.Screen
                name = 'CarteiraCadastro'
                options={{ headerShown: false}}>
                    {() => (
                        <PrivateRoute>
                            <CarteiraCadastro />
                        </PrivateRoute>
                    )}
                </Stack.Screen>
            <Stack.Screen
                name = 'Carteira'
                options={{ headerShown: false}}>
                    {() => (
                        <PrivateRoute>
                            <Carteira />
                        </PrivateRoute>
                    )}
                </Stack.Screen> 
            <Stack.Screen
                name = 'VacinaCadastro'
                options={{ headerShown: false}}>
                {() => (
                    <PrivateRoute>
                        <VacinaCadastro />
                    </PrivateRoute>
                )}
            </Stack.Screen> 
            <Stack.Screen
                name = 'MenuConfig'
                options={{ headerShown: false}}>
                {() => (
                    <PrivateRoute>
                        <MenuConfig />
                    </PrivateRoute>
                )}
            </Stack.Screen> 
        </Stack.Navigator>
    );
}

